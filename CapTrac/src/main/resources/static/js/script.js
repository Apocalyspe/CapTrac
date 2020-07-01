function addexpense_div() {
    document.getElementById("addexpense_div").style.display = "block";
    document.getElementById("schedule_div").style.display = "none";
    document.getElementById("delete_div").style.display = "none";
}

function schedule_div(){
    document.getElementById("addexpense_div").style.display = "none";
    document.getElementById("delete_div").style.display = "none";
    document.getElementById("schedule_div").style.display = "block";
}

function delete_div(){
    document.getElementById("addexpense_div").style.display = "none";
    document.getElementById("delete_div").style.display = "block";
    document.getElementById("schedule_div").style.display = "none";
}