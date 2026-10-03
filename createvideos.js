// api.js - Modern asynchronous service layer
const API_ENDPOINT = '/api/videos';

export async function fetchVideos() {
    try {
        const response = await fetch(API_ENDPOINT);
        if (!response.ok) throw new Error('Failed to fetch data');
        return await response.json();
    } catch (error) {
        console.error('API Error:', error);
        return [];
    }
}

export async function toggleLike(videoId) {
    try {
        const response = await fetch(`${API_ENDPOINT}/${videoId}/like`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' }
        });
        return await response.json();
    } catch (error) {
        console.error('Like Error:', error);
    }
}

export async function createVideo(videoData) {
    try {
        const response = await fetch(API_ENDPOINT, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(videoData)
        });
        return await response.json();
    } catch (error) {
        console.error('Creation Error:', error);
    }
}
