const myPetAct = document.getElementById("myPet");
const actPetParent = document.getElementById("petParent");

const feed = document.getElementById("feed");
const stroll = document.getElementById("stroll");
const clean = document.getElementById("clean");

const modalActLabel = document.getElementById("modalActLabel");
const actImg = document.getElementById("actImg");
const actCloseBtn = document.getElementById("actCloseBtn");
const doneFeeding = document.getElementById("doneFeeding");
const modalImg = document.getElementById("modalImg");
const petStatusBtn = document.getElementById("petStatusBtn");

const pet_exp = document.getElementById("pet_exp");
const pet_hungry = document.getElementById("pet_hungry");
const pet_hp = document.getElementById("pet_hp")

let h4One = document.createElement("h4");
let h4Two = document.createElement("h4");
let followingPetDiv = document.createElement("div");
let followingPetText = document.createElement("p");



//=====================펫 먹이주기 버튼======================
feed.addEventListener("click", ()=>{
    modalActLabel.innerHTML = "식사 중";
    actImg.src = "/resources/img/petAct/feed.gif";
    h4One.innerHTML = "";
    h4Two.innerHTML = "";
    doneFeeding.style.display = "none";
    
    setTimeout(()=>{
        fetch("./feed", {
            method: "GET"
        })
        .then(r=>r.json())
        .then((r)=>{
                pet_exp.value = r.pet_exp;
                pet_hungry.value = r.pet_hungry;

                modalActLabel.innerHTML = "다 먹었어요";
                actImg.src = "/resources/img/petAct/doneFeeding.gif";
                doneFeeding.style.display = "inline";
                h4One.innerHTML = "포만감 +10";
                h4Two.innerHTML = "경험치 +10";
                modalImg.append(h4One);
                modalImg.append(h4Two);

            })
        .then((r)=>{
            followingPetText.innerHTML = "배불러요";
            followingPetText.setAttribute("id", "followingPetText");
            followingPetDiv.append(followingPetText);
            followingPetDiv.setAttribute("id", "followingPetDiv");
            followingPetDiv.style.left = myPetAct.style.left;
            followingPetDiv.style.top = myPetAct.style.top;
            actPetParent.append(followingPetDiv);
    
            setTimeout(()=>{
                followingPetDiv.remove();
            }, 5000)

        })
            .catch(()=>{
                alert("오류");
            })
            
        }, 1500)
        

})


//=====================펫 산책하기 버튼======================
stroll.addEventListener("click", ()=>{
    modalActLabel.innerHTML = "산책 중";
    actImg.src = "/resources/img/petAct/stroll.gif";
    h4One.innerHTML = "";
    h4Two.innerHTML = "";
    doneFeeding.style.display = "none";
    
    setTimeout(()=>{
        fetch("./stroll", {
            method: "GET"
        })
        .then(r=>r.json())
        .then((r)=>{
                pet_exp.value = r.pet_exp;
                pet_hungry.value = r.pet_hungry;

                modalActLabel.innerHTML = "집으로 돌아왔어요";
                actImg.src = "/resources/img/petAct/doneFeeding.gif";
                doneFeeding.style.display = "inline";
                h4One.innerHTML = "포만감 -20";
                h4Two.innerHTML = "경험치 +10";
                modalImg.append(h4One);
                modalImg.append(h4Two);
            
        })
        .then((r)=>{
            followingPetText.innerHTML = "행복해요";
            followingPetText.setAttribute("id", "followingPetText");
            followingPetDiv.append(followingPetText);
            followingPetDiv.setAttribute("id", "followingPetDiv");
            followingPetDiv.style.left = myPetAct.style.left;
            followingPetDiv.style.top = myPetAct.style.top;
            actPetParent.append(followingPetDiv);
    
            setTimeout(()=>{
                followingPetDiv.remove();
            }, 5000)

        })
        .catch(()=>{
            alert("오류");
        })
        
    }, 1500)
    
})



//=====================펫 청소하기 버튼======================
clean.addEventListener("click", ()=>{
    modalActLabel.innerHTML = "청소 중";
    actImg.src = "/resources/img/petAct/clean.gif";
    h4One.innerHTML = "";
    h4Two.innerHTML = "";
    doneFeeding.style.display = "none";
    
    setTimeout(()=>{
        fetch("./clean", {
            method: "GET"
        })
        .then(r=>r.json())
        .then((r)=>{
                pet_hp.value = r.pet_hp;

                modalActLabel.innerHTML = "청소 끝";
                actImg.src = "/resources/img/petAct/doneFeeding.gif";
                doneFeeding.style.display = "inline";
                h4One.innerHTML = "HP +10";
                h4Two.innerHTML = "";
                modalImg.append(h4One);
                modalImg.append(h4Two);

        })
        .then((r)=>{
            followingPetText.innerHTML = "깨끗하고 좋네요";
            followingPetText.setAttribute("id", "followingPetText");
            followingPetDiv.append(followingPetText);
            followingPetDiv.setAttribute("id", "followingPetDiv");
            followingPetDiv.style.left = myPetAct.style.left;
            followingPetDiv.style.top = myPetAct.style.top;
            actPetParent.append(followingPetDiv);
    
            setTimeout(()=>{
                followingPetDiv.remove();
            }, 5000)

        })
        .catch(()=>{
            alert("오류");
        })
        
    }, 1500)
    
    
})






