handleFile = files => {
  fileUpload(files[0]);
};

erreur = () => {
  fetch("http://localhost:8080/oopsy");
};

reverse = data => {
  document.getElementById("reversed").innerHTML = "";
  fetch("http://localhost:8080/sql?data=" + data)
    .then(resp => resp.json())
    .then(
      json =>
        (document.getElementById(
          "reversed"
        ).innerHTML = `<h1>sha256(${json.source})=${json.hash}</h1>`)
    );
};

gomine = dataToHash => {
  document.getElementById("block").innerHTML = "";
  fetch("http://localhost:8080/cpu", {
    method: "POST",
    body: dataToHash
  })
    .then(resp => resp.json())
    .then(
      json =>
        (document.getElementById(
          "block"
        ).innerHTML = `<h1>sha256(${json.data})=${json.hash}</h1>`)
    );
};

fileUpload = file => {
  document.getElementById("calculatedHash").innerHTML = "";
  fetch("http://localhost:8080/memory", {
    method: "POST",
    body: file
  })
    .then(resp => resp.json())
    .then(
      json =>
        (document.getElementById(
          "calculatedHash"
        ).innerHTML = `<h1>${json.hash}</h1>`)
    );
};
