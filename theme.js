/**
 * Persistent Dark/Light Mode Theme System
 * Handles checking storage configurations, device hardware options, 
 * UI token mutations, and internal state caching.
 */
document.addEventListener('DOMContentLoaded', () => {
    // 1. Core DOM Element Selectors
    const themeToggleBtn = document.getElementById('themeToggle');
    const rootElement = document.documentElement; // Targets the <html> element

    // 2. State Resolution Engine
    // Check if the user previously selected a setting on this browser session
    const savedTheme = localStorage.getItem('theme');
    
    // Check if the user's operating system/device defaults to dark mode natively
    const systemPrefersDark = window.matchMedia('(prefers-color-scheme: dark)').matches;

    /**
     * Applies the designated theme tokens globally across the workspace
     * @param {string} theme - Accepts either 'dark' or 'light'
     */
    function applyTheme(theme) {
        if (theme === 'dark') {
            rootElement.setAttribute('data-theme', 'dark');
            localStorage.setItem('theme', 'dark');
            if (themeToggleBtn) themeToggleBtn.textContent = '☀️'; // Switch visual indicator to Sun
        } else {
            rootElement.removeAttribute('data-theme');
            localStorage.setItem('theme', 'light');
            if (themeToggleBtn) themeToggleBtn.textContent = '🌙'; // Switch visual indicator to Moon
        }
    }

    // 3. Boot & Initialize Configuration Checking
    if (savedTheme === 'dark' || (!savedTheme && systemPrefersDark)) {
        applyTheme('dark');
    } else {
        applyTheme('light');
    }

    // 4. Click Event Mutation Control
    if (themeToggleBtn) {
        themeToggleBtn.addEventListener('click', () => {
            // Read active HTML DOM attribute value to calculate the next step
            const currentActiveTheme = rootElement.getAttribute('data-theme');
            
            if (currentActiveTheme === 'dark') {
                applyTheme('light');
            } else {
                applyTheme('dark');
            }
        });
    }
});
