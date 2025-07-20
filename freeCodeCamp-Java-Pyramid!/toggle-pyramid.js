const count = 8;
const char = "#";
const rows = [];
const inverted = true;  // set false for normal pyramid

function padRow(rowNumber, rowCount) {
  return " ".repeat(rowCount - rowNumber) + char.repeat(2 * rowNumber - 1);
}

for (let i = 1; i <= count; i++) {
  if (inverted) {
    rows.unshift(padRow(i, count));
  } else {
    rows.push(padRow(i, count));
  }
}

console.log(rows.join("\n"));
/*
If inverted = true:
###############
 ############# 
  ###########  
   #########   
    #######    
     #####     
      ###      
       #       

If inverted = false:
       #       
      ###      
     #####     
    #######    
   #########   
  ###########  
 ############# 
###############
*/
