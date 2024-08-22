const chname = document.getElementById("chname");
const category_num = document.getElementById("category_num");
const fileUpload = document.getElementById("fileUpload");

let label;
let input;



//등록 이미지 수 변경 함수
function addfile(num){
 
    label = document.createElement("label");
    label.for = "imgFile"
    label.classList.add("form-label")

    switch (num){
        case 0 :
            label.innerHTML = "기본 이미지"
            break;
        case 1 :
            label.innerHTML = "2단계 이미지"
            break;
        case 2 :
            label.innerHTML = "3단계 이미지"
            break;
        case 3 :
            label.innerHTML = "4단계 이미지"
            break;
    }
        
    input = document.createElement("input")
    input.type="file"
    input.id="imgFile"
    input.name="attach"

    fileUpload.append(label)
    fileUpload.append(input)
   
}

//카테고리 변경시 등록 이미지 수, 텍스트변경 이벤트
category_num.addEventListener("change", ()=>{
    console.log("go")

    if(category_num.value == 0){
        chname.innerHTML="종족"

        fileUpload.innerHTML=""

        for(i=0;i<4;i++){
            addfile(i)
        }

        
    } else {
        chname.innerHTML="무기 이름"

        fileUpload.innerHTML=""
        
        addfile(0)
    }

})
