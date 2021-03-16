const saveButton = document.getElementById("save");

saveButton.addEventListener("click", createUser)

function validatePassword() {

    if(document.getElementById("password1").value === document.getElementById("password2").value) {

        return true
    }

    return false
}

function emailExists() {

    const getEmailToValidation = document.getElementById("email").value

    const getObject = {
        headers: {
            "Content-type": 'application/json'
        },
        method: "GET"
    }

    return new Promise(resolve =>
    fetch("http://localhost:8080/getAllUsers", getObject)
        .then(email => {
            return email.json()
        }).then(data => {
            let list = data.map(x => x.email)
            resolve(list)
        }))


}

function validateEmail(data) {
    let list = ""

    emailExists().then(data => {
        list = data;
    })

    console.log(list)
}

function createUser()
{
    if(!validatePassword()) {
        console.log("You fucked up the password")
        return;
    }

    if(emailExists()) {
        console.log("You fucked up the email")
        return;

    const url = "http://localhost:8080/postUser";

    const newUser = {
        "email": document.getElementById("email").value,
        "password":document.getElementById("password1").value,
        "firstName":document.getElementById("firstName").value,
        "lastName":document.getElementById("lastName").value,
        "dateOfBirth":document.getElementById("birthdate").value,
        "height":document.getElementById("height").value
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






