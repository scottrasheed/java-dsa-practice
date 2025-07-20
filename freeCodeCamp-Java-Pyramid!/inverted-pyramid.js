const count = 8;
const char = "#";

for (let i = count; i > 0; i--) {
  const row = " ".repeat(count - i) + char.repeat(2 * i - 1);
  console.log(row);
}
/*
###############
 ############# 
  ###########  
   #########   
    #######    
     #####     
      ###      
       #       
*/
