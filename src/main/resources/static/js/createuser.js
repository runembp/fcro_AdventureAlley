const email = document.getElementById("email");
const password = document.getElementById("password");
const firstName = document.getElementById("firstName");
const lastName = document.getElementById("lastName");
const date = document.getElementById("date");
const height = document.getElementById("height");
const saveButton = document.getElementById("save");

function createUser()
{
    const url = "http://localhost:8080/postUser";

    const newUser = {
            "email":email.value,
            "password":password.value,
            "firstName":firstName.value,
            "lastName":lastName.value,
            "date":date.value,
            "height":height.value
    }

    const newUserStringify = JSON.stringify(newUser);

    const postObject = {
            method: "POST",
            headers:
                {
                "content-type": "application/json"
                 },
            body:newUserStringify
    }
    fetch(url, postObject)
        .then(response => response.json())
        .then(x => {console.log("success")})
        .catch(x => {console.log("failure")})
}

saveButton.addEventListener('click', createUser())


