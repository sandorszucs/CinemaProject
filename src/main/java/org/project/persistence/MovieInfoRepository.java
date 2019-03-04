package org.project.persistence;

import org.project.domain.MovieInfo;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MovieInfoRepository extends PagingAndSortingRepository<MovieInfo, Long> {

    MovieInfo findMovieInfoById(long id);

}