import React from 'react';

const MovieList = ({ movies, onSelect }) => {
    return (
        <ul>
            {movies.map((movie) => (
                <li key={movie.id} onClick={() => onSelect(movie.id)}>
                    {movie.title}
                </li>
            ))}
        </ul>
    );
};

export default MovieList;