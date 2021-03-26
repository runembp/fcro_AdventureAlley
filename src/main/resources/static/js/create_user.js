function formSubmit(){
    if (!event.preventDefault()) {
        validation();
    }
}

function validatePassword() {
    if(document.getElementById("password1").value === document.getElementById("password2").value) {
        return true
    }
    return false
}

async function emailValidation()
{
    const email = document.getElementById("email").value;
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

    if(users.includes(email))
    {
        alert("Email findes allerede");
        return Promise.resolve(true);
    } else {
        return Promise.resolve(false)
    }
}

async function validation()
{
    if(validatePassword() && !(await emailValidation()))
    {
        createUser();
    }
}

function createUser() {

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
            .then(() => {
                window.location.href = "/"
            })
}