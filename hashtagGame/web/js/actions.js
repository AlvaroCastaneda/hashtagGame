
function user(boton) {
  var a1 = document.getElementById('a1').value;
  var a2 = document.getElementById('a2').value;
  var a3 = document.getElementById('a3').value;
  var b1 = document.getElementById('b1').value;
  var b2 = document.getElementById('b2').value;
  var b3 = document.getElementById('b3').value;
  var c1 = document.getElementById('c1').value;
  var c2 = document.getElementById('c2').value;
  var c3 = document.getElementById('c3').value;
  
  var x;
  var y;
  
  boton.innerHTML = "O";
  boton.value = "O";
  console.log(boton.id);
  console.log(boton.value);
  
  $.post("gato/juego.htm", 
  {
      a1: a1,
      a2: a2,
      a3: a3,
      b1: b1,
      b2: b2,
      b3: b3,
      c1: c1,
      c2: c2,
      c3: c3
  },
    function(retorno){
        console.log(retorno);
        x = retorno.x;
        y = retorno.y;
        console.log(x);
        console.log(y);
    });
}
