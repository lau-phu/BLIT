import axios from "axios"


const url = axios.create({
    baseURL: "http://localhost:8080",
})




function login(username, password) {

    const string = "/login?username=" + username + "&password=" + password

    const log = () => url.get(string)

    return log();
}

const getDiary = () => url.get("/diaries");

export { login, getDiary };

