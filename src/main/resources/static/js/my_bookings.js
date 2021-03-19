const dropdownMyBookings = document.getElementById("dropdownMyBooking");

async function getCurrentUser(){

    const email = window.location.pathname.substring(19);
    const userUrl = `http://localhost:8080/findUserByEmail/${email}`

    const data = await fetch(userUrl);
    const user = await data.json();

    return user;

}

let user = getCurrentUser()
    .then(data => user = data)
    .then(user => {console.log(user)});




