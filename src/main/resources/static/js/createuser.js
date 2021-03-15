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

    const requestObject =
        {
            headers
        }

    let newUser =
        {
            "email":email,
            "password":password,
            "firstName":firstName,
            "lastName":lastName,
            "date":date,
            "height":height
        }


}

saveButton.addEventListener('click', createUser())


