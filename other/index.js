function future(){
	return "we still have no future";
}
console.log("ALl people say is: ", future());
var person =
{   
    first_name: "Xuqiang",
    last_name: "Fang",
    age: 26,
    nationality: "chinese",
    eyeColor: "black",
    display: function display_everything(){
		console.log(this.first_name, " ", this.last_name, " ", this.age, this.nationality,this.eyeColor);
	}
};
person.display();
