window.onload = async function createOverview() {
    const url = "http://localhost:8080/findAllActivities";

    const activity_container = document.getElementById("activity_container")

    const getObject = {
        method:"GET",
        headers: {
            "Content-type":"application/json"
        }
    }

    const response = await fetch(url, getObject);
    const data = await response.json();

    let divide_and_conquer = data.length;

    data.forEach(x  => {
        if (divide_and_conquer % 2 === 0 && divide_and_conquer !== 0) {
            console.log(divide_and_conquer);
            divide_and_conquer -= 1;

            const row = document.createElement('div');
            row.setAttribute('class', 'row');
            activity_container.appendChild(row);

            const col_left = document.createElement('div');
            col_left.setAttribute('class', 'col');
            row.appendChild(col_left);

            const h1 = document.createElement('h1');
            h1.setAttribute('class', 'text-danger' + ' ms-5');
            h1.textContent = x.title;
            col_left.appendChild(h1);

            const p = document.createElement('p');
            p.setAttribute('class', 'text-danger ms-5')
            p.textContent = x.description;
            col_left.appendChild(p);

            const p_price = document.createElement('p');
            p_price.setAttribute('class', 'text-danger ms-5');
            p_price.textContent = "Price: " + x.price;
            col_left.appendChild(p_price);

            const p_height = document.createElement('p');
            p_height.setAttribute('class', 'text-danger ms-5');
            p_height.textContent = "Minimum height: " + x.minHeight;
            col_left.appendChild(p_height);

            const col_right = document.createElement('div');
            col_right.setAttribute('class', 'col text-center');
            row.appendChild(col_right);

            /*const img = document.createElement('img');
            img.setAttribute('class', 'h-100 w-50 p-4');
            img.setAttribute('src', 'https://images.pexels.com/photos/861464/pexels-photo-861464.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260');
            col_right.appendChild(img);*/
        }
        if (divide_and_conquer % 2 !== 0 && divide_and_conquer !== 0) {
            console.log(divide_and_conquer);
            divide_and_conquer -= 1;

            const row = document.createElement('div');
            row.setAttribute('class', 'row');
            activity_container.appendChild(row);

            const col_left = document.createElement('div text-center');
            col_left.setAttribute('class', 'col');
            row.appendChild(col_left);

            const col_right = document.createElement('div');
            col_right.setAttribute('class', 'col');
            row.appendChild(col_right);

            const h1 = document.createElement('h1');
            h1.setAttribute('class', 'text-danger' + ' ms-5');
            h1.textContent = x.title;
            col_right.appendChild(h1);

            const p = document.createElement('p');
            p.setAttribute('class', 'text-danger ms-5')
            p.textContent = x.description;
            col_right.appendChild(p);

            const p_price = document.createElement('p');
            p_price.setAttribute('class', 'text-danger ms-5 fw-bold');
            p_price.textContent = "Price: " + x.price;
            col_right.appendChild(p_price);

            const p_height = document.createElement('p');
            p_height.setAttribute('class', 'text-danger ms-5 fw-bold');
            p_height.textContent = "Minimum height: " + x.minHeight;
            col_right.appendChild(p_height);

            /*const img = document.createElement('img');
            img.setAttribute('class', 'h-100 w-50 p-4');
            img.setAttribute('src', 'https://images.pexels.com/photos/861464/pexels-photo-861464.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260');
            col_left.appendChild(img);*/
        }
    })
}