
import React, { useState } from 'react';
import MovieSearch from './components/MovieSearch';
import MovieList from './components/MovieList';
import MovieDetails from './components/MovieDetails';
import './styles.css';

function App() {
  const [movies, setMovies] = useState([]);
    const [selectedMovieId, setSelectedMovieId] = useState(null);

    return (
        <div className="App">
            <MovieSearch onSearch={setMovies} />
            <MovieList movies={movies} onSelect={setSelectedMovieId} />
            {selectedMovieId && <MovieDetails movieId={selectedMovieId} />}
        </div>
    );
}

export default App;
