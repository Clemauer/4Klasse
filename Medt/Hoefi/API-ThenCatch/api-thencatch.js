const url = 'https://randomuser.me/api';

fetch(url)
    .then(response => {
        if (!response.ok) throw new Error(`HTTP error! status: ${response.status}`);
        return response.json();
    })
    .then(data => {
        const user = data.results[0];
        const fullName = `${user.name.first} ${user.name.last}`;
        console.log(`${fullName}`);
    })
    .catch(error => console.error('Error:', error));

async function fetchUser() {
    try {
            const response = await fetch(url);
            const data = await response.json();
            const user = data.results[0];
            const fullName = `${user.name.first} ${user.name.last}`;
            return fullName;

    } catch (error) {
        console.error('Error:', error);
    }
}

const result = await fetchUser();
console.log(await fetchUser());