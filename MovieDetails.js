import React, { useState, useEffect } from 'react';
import axios from 'axios';

const MovieDetails = ({ movieId }) => {
    const [movie, setMovie] = useState(null);
    const [reviews, setReviews] = useState([]);

    useEffect(() => {
        const fetchMovieDetails = async () => {
            const response = await axios.get(`http://localhost:8080/api/movies/${movieId}`);
            setMovie(response.data);
        };

        const fetchReviews = async () => {
            const response = await axios.get(`http://localhost:8080/api/movies/${movieId}/reviews`);
            setReviews(response.data);
        };

        fetchMovieDetails();
        fetchReviews();
    }, [movieId]);

    return (
        <div>
            {movie && (
                <>
                    <h2>{movie.title}</h2>
                    <p>{movie.description}</p>
                    <h3>Reviews</h3>
                    <ul>
                        {reviews.map((review) => (
                            <li key={review.id}>
                                <strong>{review.userName}</strong>: {review.content} ({review.rating}/5)
                            </li>
                        ))}
                    </ul>
                </>
            )}
        </div>
    );
};

export default MovieDetails;
