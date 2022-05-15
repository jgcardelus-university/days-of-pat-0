const getDatos = async () => {
    let request = await fetch("/api/v1/users");
    if (request.status === 200) {
        const data = await request.json();
        document.getElementById("result").innerHTML = data.toString();
    }
};
