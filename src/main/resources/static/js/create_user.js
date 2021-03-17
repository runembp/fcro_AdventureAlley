const saveButton = document.getElementById("save");

saveButton.addEventListener("click", create_user)

function validatePassword() {

    if(document.getElementById("password1").value === document.getElementById("password2").value) {

        return true
    }

    return false
}

function create_user()
{
    if(!validatePassword()) {
        console.log("You fucked up")
        return;
    }

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
            window.location.href = "/"
        })
        .catch(response => {
            console.log("failure")
        })
}






