const wpdiv = document.getElementById("wpdiv")
const category = document.getElementById("category")

category.addEventListener("change",()=>{

    let label = document.createElement("label")
    label.setAttribute("for","weapon_description")
    label.innerHTML="설명"
    let input = document.createElement("input")
    input.type = "text"
    input.classList.add("form-control")
    input.id = "weapon_description"
    input.name = "weapon_description"

    if(category.value==1){
        wpdiv.append(label)
        wpdiv.append(input)
    } else {
        wpdiv.innerHTML="";
    }

})