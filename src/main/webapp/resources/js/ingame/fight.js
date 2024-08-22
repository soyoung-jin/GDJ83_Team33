// 펫 이미지
const petImg = document.getElementById("petImg");
const enemyImg = document.getElementById("enemyImg")

// 펫 무기 이미지
const weaponImg = document.getElementById("weaponImg");
const enemyWeaponImg = document.getElementById("enemyWeaponImg");

// 펫 대사
const line = document.getElementById("line");
const enemyLine = document.getElementById("enemyLine");

// 대사 감싼 div
const lineParent = document.getElementById("lineParent");
const lineEnemyParent = document.getElementById("lineEnemyParent");

//싸우기 버튼
const fightBtn = document.getElementById("fightBtn");
const clickMe = document.getElementById("clickMe");

const popoverTriggerList = document.querySelectorAll('[data-bs-toggle="popover"]')
const popoverList = [...popoverTriggerList].map(popoverTriggerEl => new bootstrap.Popover(popoverTriggerEl))



fightBtn.addEventListener("click", ()=>{
    lineParent.remove();
    lineEnemyParent.remove();
    fightBtn.remove();
    clickMe.remove();
    petImg.style.cursor="pointer";
})

petImg.addEventListener("click", ()=>{
    
})



