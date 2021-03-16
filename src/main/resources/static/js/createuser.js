const saveButton = document.getElementById("save");

saveButton.addEventListener("click", createUser)

function validatePassword() {
    if(document.getElementById("password1").value === document.getElementById("password2").value) {
        return true
    }
    return false
}

async function emailExists() {

    const url = "http://localhost:8080/getAllUsers";
    const getObject = {
        headers: {
            "Content-type": 'application/json'
        },
        method: "GET"
    }

    return await new Promise(resolve =>
        fetch(url, getObject)
        .then(email => email.json())
        .then(data => {
            resolve(data.map(x => x.email))
        }))
}

async function testing()
{
    const url = "http://localhost:8080/getAllUsers";
    const getObject = {
        headers: {
            "Content-type": 'application/json'
        },
        method: "GET"
    }

    const response = await fetch(url, getObject);
    let users = await response.json();
    users = users.map(x => x.email)

    if(users.includes(document.getElementById("email")))
    {
        console.log("Email found!")
        return true;
    }
    return false;

}

testing();

function createUser() {
    if (!validatePassword()) {
        console.log("You fucked up the password")
        return;
    }

    if (emailExists()) {
        console.log("You fucked up the email")
        return;

        const url = "http://localhost:8080/postUser";

        const newUser = {
            "email": document.getElementById("email").value,
            "password": document.getElementById("password1").value,
            "firstName": document.getElementById("firstName").value,
            "lastName": document.getElementById("lastName").value,
            "dateOfBirth": document.getElementById("birthdate").value,
            "height": document.getElementById("height").value
        }

        const newUserStringified = JSON.stringify(newUser);

        const postObject = {
            headers:
                {
                    "Content-type": 'application/json'
                },
            method: 'POST',
            body: newUserStringified
        };

        fetch(url, postObject)
            .then(response => response.json())
            .then(response => {
                console.log("success")
                //  window.location.href = "/"
            })
            .catch(response => {
                console.log("failure")
            })
    }
}