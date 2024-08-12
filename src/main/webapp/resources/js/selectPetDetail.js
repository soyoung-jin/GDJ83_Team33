const categori = document.getElementById("categori");


categori.addEventListener("change", ()=>{
    location.href = '/mypet/petDetail?pet_num=' + categori.value;
})