const chname = document.getElementById("chname");
const category_num = document.getElementById("category_num");
const fileUpload = document.getElementById("fileUpload");
const btn = document.getElementById("btn");
const fileList = document.getElementsByClassName("fileList");
const add = document.getElementById("add")

let label;
let input;

const itemname = document.getElementById("name")
const description = document.getElementById("description");
const hp = document.getElementById("hp");
const atk = document.getElementById("atk");
const dod = document.getElementById("dod");
const price = document.getElementById("price");

const name_error = document.getElementById("name_error");
const description_error = document.getElementById("description_error");
const hp_error = document.getElementById("hp_error");
const atk_error = document.getElementById("atk_error");
const dod_error = document.getElementById("dod_error");
const price_error = document.getElementById("price_error");

let error = null;

//파일 확장자 gif만 가능
add.addEventListener("change",(e)=>{
    if(e.target.classList.contains("fileList")){
        if(e.target.files[0].type != 'image/gif'){
            console.log("type="+e.target.files[0].type)
            alert("gif 파일을 넣어주세요.")
        }
    }
})

let reqExpEng = /[A-Za-z]/g;
let reqExpNum = /[0-9]/g;
let reqExpKor = /[ㄱ-ㅎ]/g
let reqExpSpe = /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"\s]/g


price.addEventListener("blur", ()=>{

    price_error.innerHTML = '';
    error = document.createElement("p");
    error.style="color:red;";

    btn.disabled = true;

    let ar = [];
    ar = price.value.match(reqExpNum)

    if(reqExpSpe.test(price.value)) {
        error.innerText="공백 확인"
    } else {
        reqExpNum = /[^0-9]/g
        price.value=price.value.replace(reqExpNum,"");
        price.setAttribute("value",price.value)
        btn.disabled = false;
        if(price.value%100!=0){
            error.innerText="1000원 단위로 입력";
            btn.disabled = true;
        }
    }
    price_error.append(error);
})

dod.addEventListener("blur", ()=>{

    dod_error.innerHTML = '';
    error = document.createElement("p");
    error.style="color:red;";

    btn.disabled = true;

    let ar = [];
    ar = dod.value.match(reqExpNum)

    if(reqExpSpe.test(dod.value)) {
        error.innerText="공백 확인"
    } else {
        reqExpNum = /[^0-9]/g
        dod.value=dod.value.replace(reqExpNum,"");
        dod.setAttribute("value",dod.value)
        btn.disabled = false;
    } 
    dod_error.append(error);
})

atk.addEventListener("blur", ()=>{

    atk_error.innerHTML = '';
    error = document.createElement("p");
    error.style="color:red;";

    btn.disabled = true;

    let ar = [];
    ar = atk.value.match(reqExpNum)

    if(reqExpSpe.test(atk.value)) {
        error.innerText="공백 확인"
    } else {
        reqExpNum = /[^0-9]/g
        atk.value=atk.value.replace(reqExpNum,"");
        atk.setAttribute("value",atk.value)
        btn.disabled = false;
    }

    atk_error.append(error);
})

hp.addEventListener("blur", ()=>{

    hp_error.innerHTML = '';
    error = document.createElement("p");
    error.style="color:red;";

    btn.disabled = true;

    let ar = [];
    ar = hp.value.match(reqExpNum)

    if(reqExpSpe.test(hp.value)) {
        error.innerText="공백 확인"
    } else{
        reqExpNum = /[^0-9]/g
        hp.value=hp.value.replace(reqExpNum,"");
        hp.setAttribute("value",hp.value)
        btn.disabled = false;
    }

    hp_error.append(error);
})

description.addEventListener("blur", ()=>{

    description_error.innerHTML = '';
    error = document.createElement("p");
    error.style="color:red;";

    btn.disabled = true;

    if (reqExpKor.test(description.value)){
        error.innerText="문장을 완성해주세요."
    } else if (reqExpEng.test(description.value)){
        error.innerText="영어 사용 불가"
    } else {
        btn.disabled = false;
    }

    description_error.append(error);
})


itemname.addEventListener("blur", ()=>{

    let flag = true;
    name_error.innerHTML = '';
    error = document.createElement("p");
    error.style="color:red;";

    btn.disabled = true;

    if(reqExpSpe.test(itemname.value)){
        error.innerText="특수문자 및 공백 확인"
    } else if (reqExpKor.test(itemname.value)){
        error.innerText="이름을 완성해주세요."
    } else if (reqExpEng.test(itemname.value)){
        error.innerText="영어 사용 불가"
    } else if (reqExpNum.test(itemname.value)){
        error.innerText="숫자 사용 불가"
    } else {
        btn.disabled = false;
        flag = false;

    }

    name_error.append(error);

    if(btn.value=='아이템 수정'){
        return;
    }

    if(!flag){
        fetch("checkItemName?item_name="+itemname.value,{
            method:"get"
        }).then(r=>r.text())
        .then(r=>{
            console.log(r)
    
            if(r==0){
                name_error.innerHTML = '';
                error = document.createElement("p");
                error.style="color:red;";
                error.innerText="같은 이름의 아이템이 있습니다."
                name_error.append(error)
    
                btn.disabled = true;
            } else {
                name_error.innerHTML = '';
                btn.disabled = false;
            }
        }).catch(()=>{})
    }
})

 
//등록 이미지 수 변경 함수
function addfile(num){
 
    label = document.createElement("label");
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
    input.name="attach"
    input.classList.add("fileList")

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
