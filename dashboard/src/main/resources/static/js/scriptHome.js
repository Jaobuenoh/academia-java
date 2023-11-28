// essa funcao verifica o 'href' do link do arquivo CSS, depois modifica o mesmo
function toggle() {
  var el = document.getElementById("style1");
  if (el.href.match("/css/styleHomeLaranja.css")) {
    el.href = "/css/styleHomeRoxo.css";
  } else {
    el.href = "/css/styleHomeLaranja.css";
  }
}
