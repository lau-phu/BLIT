// signup.js


export default function Signup() {
    const form = `
  <form id="signup-form">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username"><br><br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password"><br><br>
    <input type="submit" value="Sign up">
  </form>
  <div id="error-message"></div>
`;

    // Display the form
    document.body.innerHTML = form;

    // Add an event listener to the form submission
    document.getElementById('signup-form').addEventListener('submit', (e) => {
        e.preventDefault();
        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;

        // Fetch the users.json file
        fetch('users.json')
            .then(response => response.json())
            .then(users => {
                // Check if the username exists in the users.json file
                const existingUser = users.find((user) => user.username === username);
                if (existingUser) {
                    document.getElementById('error-message').innerHTML = 'Username is taken';
                } else {
                    // Add the new user to the users.json file
                    const newUser = { username, password };
                    users.push(newUser);
                    const json = JSON.stringify(users, null, 2);
                    fetch('users.json', {
                        method: 'PUT',
                        headers: { 'Content-Type': 'application/json' },
                        body: json
                    })
                        .then(() => {
                            document.getElementById('error-message').innerHTML = 'Account created successfully!';
                        })
                        .catch((err) => {
                            console.error(err);
                            document.getElementById('error-message').innerHTML = 'Error creating account';
                        });
                }
            })
            .catch((err) => {
                console.error(err);
                document.getElementById('error-message').innerHTML = 'Error loading users.json';
            });
    });
}