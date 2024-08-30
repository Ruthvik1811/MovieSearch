import React, { useState } from 'react';
import axios from 'axios';

const MovieSearch = ({ onSearch }) => {
    const [query, setQuery] = useState('');

    const handleSearch = async () => {
        const response = await axios.get(`http://localhost:8080/api/movies?query=${query}`);
        onSearch(response.data);
    };

    return (
        <div>
            <input
                type="text"
                value={query}
                onChange={(e) => setQuery(e.target.value)}
                placeholder="Search for movies..."
            />
            <button onClick={handleSearch}>Search</button>
        </div>
    );
};

export default MovieSearch;