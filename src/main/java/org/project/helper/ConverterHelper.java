package org.project.helper;

import org.project.domain.*;
import org.project.dto.*;
import org.project.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ConverterHelper {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HallRepository hallRepository;

    @Autowired
    private MovieInfoRepository movieInfoRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private ReservedSeatRepository reservedSeatRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;


    public List<ReservedSeat> convertReservedSeats(List<ReservedSeatDTO> reservedSeatDTOs) {
        List<ReservedSeat> reservedSeats = new ArrayList<>();
        for (ReservedSeatDTO seatDTO : reservedSeatDTOs) {
            ReservedSeat reservedSeat = reservedSeatRepository.findReservedSeatById(seatDTO.getId());
            if (reservedSeat == null) {
                reservedSeat = new ReservedSeat();
            }
            reservedSeat.setId(seatDTO.getId());
            List<Seat> seat = convertSeat(Arrays.asList(seatDTO.getSeat()));
            reservedSeat.setSeat(seat.get(0));
            reservedSeats.add(reservedSeat);
        }
        return reservedSeats;
    }

    public List<ReservedSeatDTO> convertReservedSeatsToDto(List<ReservedSeat> reservedSeats) {
        List<ReservedSeatDTO> reservedSeatsDTO = new ArrayList<>();

        for (ReservedSeat reservedSeat : reservedSeats) {
            ReservedSeatDTO reservedSeatDTO = new ReservedSeatDTO();
            reservedSeatDTO.setId(reservedSeat.getId());
            reservedSeatDTO.setUser(convertUserToDto(reservedSeat.getUser()));
            reservedSeatDTO.setSeat(convertToSeatDto(reservedSeat.getSeat()));
            reservedSeatsDTO.add(reservedSeatDTO);
        }
        return reservedSeatsDTO;
    }

    public Hall convertHall(HallDTO hallDTO, long id) {
        Hall hall = hallRepository.findHallById(id);
        if (hall == null) {
            hall = new Hall();// if hall doesn't exist in the data base, ex: findById returns null,
            // then create new hall Object
        }
        hall.setCapacity(hallDTO.getCapacity());
        hall.setId(hallDTO.getId());
        hall.setLocation(hallDTO.getLocation());
        List<Seat> seats = convertSeat(hallDTO.getSeats());
        hall.setSeats(seats);
        return hall;
    }

    public HallDTO convertHallToDto(Hall hall) {
        HallDTO hallDTO = new HallDTO();

        hallDTO.setId(hall.getId());
        hallDTO.setLocation(hall.getLocation());
        hallDTO.setCapacity(hall.getCapacity());

        List<Seat> seats = hall.getSeats();
        hallDTO.setSeats(convertSeatToDto(seats));

        return hallDTO;

    }

    public List<SeatDTO> convertSeatToDto(List<Seat> seats) {
        List<SeatDTO> seatsDTO = new ArrayList<>();

        for (Seat seat : seats) {

            SeatDTO seatDTO = convertToSeatDto(seat);
            seatsDTO.add(seatDTO);
        }
        return seatsDTO;
    }

    public SeatDTO convertToSeatDto(Seat seat) {
        SeatDTO seatDTO = new SeatDTO();
        seatDTO.setId(seat.getId());
        seatDTO.setSeatNumber(seat.getSeatNumber());
        seatDTO.setRow(seat.getRow());
        return seatDTO;
    }


    public List<Seat> convertSeat(List<SeatDTO> seatDTOs) {// example 5 seatDTO
        List<Seat> seats = new ArrayList<>();
        for (SeatDTO seatDTO : seatDTOs) { //for every seatDTO in the list of 5
            Seat seat = convertSeat(seatDTO);

            seats.add(seat);
        }
        return seats; //returns list of seats which were converted from seatDTO
    }

    public Seat convertSeat(SeatDTO seatDTO) {
        Seat seat = seatRepository.findSeatById(seatDTO.getId());
        if (seat == null) {
            seat = new Seat();
        }

        seat.setId(seatDTO.getId());
        seat.setRow(seatDTO.getRow());
        seat.setSeatNumber(seatDTO.getSeatNumber());
        return seat;
    }


    public MovieInfo convertMovieInfo(MovieInfoDTO movieDTO, long id) {
        MovieInfo movieInfo = movieInfoRepository.findMovieInfoById(id);
        if (movieInfo == null) {
            movieInfo = new MovieInfo();
        }
        movieInfo.setActor(movieDTO.getActor());
        movieInfo.setDirector(movieDTO.getDirector());
        movieInfo.setGenre(movieDTO.getGenre());
        movieInfo.setId(movieDTO.getId());
        movieInfo.setProduction(movieDTO.getProduction());
        movieInfo.setTitle(movieDTO.getTitle());

        return movieInfo;
    }

    @Transactional
    public MovieInfoDTO convertMovieInfoToDto(MovieInfo movieInfo) {
        MovieInfoDTO movieInfoDTO = new MovieInfoDTO();

        movieInfoDTO.setId(movieInfo.getId());
        movieInfoDTO.setTitle(movieInfo.getTitle());
        movieInfoDTO.setActor(movieInfo.getActor());
        movieInfoDTO.setDirector(movieInfo.getDirector());
        movieInfoDTO.setGenre(movieInfo.getGenre());
        movieInfoDTO.setProduction(movieInfo.getProduction());

        return movieInfoDTO;
    }

    public User convertUser(UserDTO userDTO, long id) {
        User user = userRepository.findUserById(id);
        if (user == null) {
            user = new User();
        }
        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPassword(userDTO.getPassword());
        user.setTelephoneNumber(userDTO.getTelephoneNumber());
        user.setEmail(userDTO.getEmail());
        return user;
    }

    public UserDTO convertUserToDto(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        userDTO.setTelephoneNumber(user.getTelephoneNumber());

        return userDTO;
    }

    public Schedule convertSchedule(ScheduleDTO scheduleDTO) {
        Schedule schedule = new Schedule();
        schedule.setMovieStartTime(scheduleDTO.getMovieStartTime());
        schedule.setId(scheduleDTO.getId());

        // todo: avoid NPE
        MovieInfo movieInfo = convertMovieInfo(scheduleDTO.getMovieInfo(), scheduleDTO.getMovieInfo().getId());
        schedule.setMovieInfo(movieInfo);
        return schedule;
    }

    public ScheduleDTO convertScheduleToDto(Schedule schedule) {
        ScheduleDTO scheduleDTO = new ScheduleDTO();

        scheduleDTO.setId(schedule.getId());
        scheduleDTO.setMovieStartTime(schedule.getMovieStartTime());

        HallDTO hall = convertHallToDto(schedule.getHall());
        scheduleDTO.setHall(hall);

        MovieInfoDTO movieInfo = convertMovieInfoToDto(schedule.getMovieInfo());
        scheduleDTO.setMovieInfo(movieInfo);

        List<ReservedSeatDTO> reservedSeat = convertReservedSeatsToDto(schedule.getReservedSeats());
        scheduleDTO.setReservedSeats(reservedSeat);

        return scheduleDTO;
    }

    public ReservationDTO convertReservationToDto(Reservation reservation) {

        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setId(reservation.getId());
        reservationDTO.setTicketAvailableNr(reservation.getTicketAvailableNr());
        reservationDTO.setDateTime(reservation.getDateTime());
        reservationDTO.setScheduleId(reservation.getSchedule().getId());
        reservationDTO.setReservedSeats(reservation.getReservedSeat().stream().map(rv -> rv.getSeat().getRow() + "_" + rv.getSeat().getSeatNumber()).collect(Collectors.toList()));
        return reservationDTO;
    }

    public Reservation convertReservation(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();

        Schedule schedule = scheduleRepository.findOne(reservationDTO.getScheduleId());
        User user = userRepository.findOne(reservationDTO.getUserId());
        List<Seat> seatsInHall = schedule.getHall().getSeats();
        List<ReservedSeat> reservedSeats = new ArrayList<>();
        for (String rv : reservationDTO.getReservedSeat()) {
            String[] seatDetails = rv.split("_");
            Optional<Seat> first = seatsInHall.stream().filter(seat -> seat.getSeatNumber() == Long.valueOf(seatDetails[1]) &&
                    seat.getRow() == Long.valueOf(seatDetails[0])).findFirst();
            Seat seat = first.orElseThrow(() -> new IllegalArgumentException("Invalid seat " + rv));
            ReservedSeat reservedSeat1 = new ReservedSeat();
            reservedSeat1.setSeat(seat);
            reservedSeat1.setUser(user);
            reservedSeat1.setSchedule(schedule);
            reservedSeats.add(reservedSeat1);
        }
        reservation.setReservedSeat(reservedSeats);
        reservation.setId(reservationDTO.getId());
        reservation.setTicketAvailableNr(reservationDTO.getTicketAvailableNr());
        reservation.setDateTime(reservationDTO.getDateTime());
        reservation.setUser(user);
        reservation.setSchedule(schedule);
        return reservation;
    }
}