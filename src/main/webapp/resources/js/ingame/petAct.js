//=====================이미지 관련======================
const myPetAct = document.getElementById("myPet"); //다마고치 이미지
const actPetParent = document.getElementById("petParent"); //다마고치 이미지 감싼 것
const actImg = document.getElementById("actImg"); //모달 안의 이미지
const modalImg = document.getElementById("modalImg"); //actImg 감싼 태그
const weaponImg = document.createElement("img");


//=====================버튼 관련======================
const petStatusBtn = document.getElementById("petStatusBtn"); //펫 상태보기 버튼
const feed = document.getElementById("feed"); //먹이주기 버튼
const stroll = document.getElementById("stroll"); //산책하기 버튼
const clean = document.getElementById("clean"); //청소하기 버튼
const levelUpBtn = document.getElementById("levelUp"); //레벨업하기 버튼
const actCloseBtn = document.getElementById("actCloseBtn"); //모달 닫기 버튼
const done = document.getElementById("done"); //모달 닫기 확인 버튼

//=====================텍스트 관련======================
const modalActLabel = document.getElementById("modalActLabel"); //모달 제목
const petReady = document.getElementById("petReady"); //펫 이름 부분(제목)
let h4One = document.createElement("h4"); //모달 안 하단 텍스트
let h4Two = document.createElement("h4"); //모달 안 하단 텍스트
let followingPetDiv = document.createElement("div"); //펫 옆에 뜨는 말풍선
let followingPetText = document.createElement("p"); //펫 옆에 뜨는 말풍선 텍스트

//=====================펫 정보 관련======================
let petNum = petStatusBtn.getAttribute("data-pet-status"); //펫 번호
const pet_exp = document.getElementById("pet_exp"); //경험치
const pet_hungry = document.getElementById("pet_hungry"); //포만감
const pet_hp = document.getElementById("pet_hp"); //체력
const pet_atk = document.getElementById("pet_atk"); //공격
const pet_dod = document.getElementById("pet_dod"); //회피
const pet_level = document.getElementById("pet_level"); //레벨
const pet_name = document.getElementById("pet_name"); //이름
const pet_washroom = document.getElementById("pet_washroom");//화장실
const pet_evolution = document.getElementById("pet_evolution"); //진화단계







//=====================펫 먹이주기 버튼======================
feed.addEventListener("click", ()=>{
    modalActLabel.innerHTML = "식사 중";
    actImg.src = "/resources/img/petAct/feed.gif";
    h4One.innerHTML = "";
    h4Two.innerHTML = "";
    done.style.display = "none";
    actCloseBtn.style.display = "none";
    
    setTimeout(()=>{
        fetch("./feed?pet_num=" + petNum, {
            method: "GET"
        })
        .then(r=>r.json())
        .then((r)=>{
                pet_exp.value = r.pet_exp;
                pet_hungry.value = r.pet_hungry;
                pet_washroom.value = r.pet_washroom;

                modalActLabel.innerHTML = "다 먹었어요";
                actImg.src = "/resources/img/petAct/doneFeeding.gif";
                done.style.display = "inline";
                actCloseBtn.style.display = "inline";
                h4One.innerHTML = "포만감 +50";
                h4Two.innerHTML = "경험치 +50";
                modalImg.append(h4One);
                modalImg.append(h4Two);

                if(r.pet_exp>=200) {
                    done.addEventListener("click", ()=>{
                        alert("레벨업 버튼을 눌러주세요");
                    })
                    petStatusBtn.innerHTML = "레벨업!";
                }

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
            }, 10000)

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
    done.style.display = "none";
    actCloseBtn.style.display = "none";
    
    setTimeout(()=>{
        fetch("./stroll?pet_num=" + petNum, {
            method: "GET"
        })
        .then(r=>r.json())
        .then((r)=>{
                pet_exp.value = r.pet_exp;
                pet_hungry.value = r.pet_hungry;

                modalActLabel.innerHTML = "집으로 돌아왔어요";
                actImg.src = "/resources/img/petAct/doneFeeding.gif";
                done.style.display = "inline";
                actCloseBtn.style.display = "inline";
                h4One.innerHTML = "경험치 +50";
                h4Two.innerHTML = "포만감 -20";
                
                modalImg.append(h4One);
                modalImg.append(h4Two);

                if(r.pet_exp>=200) {
                    
                    petStatusBtn.innerHTML = "레벨업!";
                    done.addEventListener("click", ()=>{
                        alert("레벨업 버튼을 눌러주세요");
                    })
                }

                if(r.pet_hungry <= 0) {
                    pet_hungry.value = 0;
                    
                }

            
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
            }, 10000)

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
    done.style.display = "none";
    actCloseBtn.style.display = "none";
    
    setTimeout(()=>{
        fetch("./clean?pet_num=" + petNum, {
            method: "GET"
        })
        .then(r=>r.json())
        .then((r)=>{
                
                pet_washroom.value = r.pet_washroom;
                pet_hungry.value = r.pet_hungry;

                modalActLabel.innerHTML = "청소 끝";
                actImg.src = "/resources/img/petAct/doneFeeding.gif";
                done.style.display = "inline";
                actCloseBtn.style.display = "inline";
                
                h4Two.innerHTML = "포만감 -20";
                
                modalImg.append(h4One);
                modalImg.append(h4Two);
                
                weaponImg.remove();

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
            }, 10000)

        })
        .catch(()=>{
            alert("오류");
        })
        
    }, 1500)
    
    
})

//=====================펫 상태보기======================
petStatusBtn.addEventListener("click", ()=>{
    levelUpBtn.style.display = "none";
    petReady.innerHTML = pet_name.value;
    pet_exp.style.border="";

    fetch("./checkPetStatus?pet_num=" + petNum,  {
        method: "GET"
    })
    .then(r=>{return r.json()})
    .then((r)=> {

        // 장비장착시 능력 추가
        
        
        if(r.pet_exp >= 200) {
            pet_exp.value = r.pet_exp;
            pet_level.value = r.pet_level;

            
            pet_exp.style.border="solid 2px red";
            levelUpBtn.style.display = "inline";
            petReady.innerHTML="레벨업 준비완료";
            
        } 

        if(r.pet_washroom >= 100) {
            pet_washroom.value = r.pet_washroom;

            weaponImg.src = "/resources/img/ingame/poop.png";
            weaponImg.setAttribute("id", "poop");

            followingPetText.innerHTML = "청소해주세요";
            followingPetText.setAttribute("id", "followingPetText");
            followingPetDiv.append(followingPetText);
            followingPetDiv.setAttribute("id", "followingPetDiv");
            followingPetDiv.style.left = myPetAct.style.left;
            followingPetDiv.style.top = myPetAct.style.top;
            actPetParent.append(followingPetDiv);
            actPetParent.append(weaponImg);
    
            setTimeout(()=>{
                followingPetDiv.remove();
            }, 20000)

        }
        
    })

})


//=====================펫 진화하기======================
levelUpBtn.addEventListener("click", ()=>{
    modalActLabel.innerHTML = "진화 중";
    actImg.src = "/resources/img/petAct/waiting.gif";
    h4One.innerHTML = "";
    h4Two.innerHTML = "";
    done.style.display = "none";
    actCloseBtn.style.display = "none";

    setTimeout(()=>{
        fetch("./levelUp?pet_num=" + petNum, {
            method: "GET"
        })
        .then(r=>r.json())
        .then((r)=>{
            pet_exp.value = r.pet_exp;
            pet_level.value = r.pet_level;
            pet_evolution.value = r.pet_evolution;
            
            modalActLabel.innerHTML = "레벨: " + r.pet_level;
            done.style.display = "inline";
            actCloseBtn.style.display = "inline";
            h4One.innerHTML = "~~~~레벨업 완료~~~~";
            
            modalImg.append(h4One);
            modalImg.append(h4Two);
            
            done.addEventListener("click",()=>{
                location.href = "./ingame";
            })
            

           
        })
        
        .catch(()=>{
            alert("오류");
        })
    }, 1400)
})









