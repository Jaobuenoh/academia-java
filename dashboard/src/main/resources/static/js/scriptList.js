// Validações para não realizar auterações sem necessidade
function confirmEdit(event) {
  event.preventDefault();

  if (confirm("Tem certeza que deseja editar?")) {
    // Se o usuário confirmar a edição, redirecione para o URL de edição
    window.location.href = event.target.getAttribute("href");
  } else {
    // Caso contrário, não faça nada
    return false;
  }
}

function confirmDelete(event) {
  event.preventDefault(); // Impede o redirecionamento padrão
  if (confirm("Tem certeza que deseja excluir?")) {
    // Se o usuário confirmar a exclusão, redirecione para o URL de exclusão
    window.location.href = event.target.getAttribute("href");
  } else {
    // Caso contrário, não faça nada
    return false;
  }
}

// Busca do items e suas especificações

function procurarItemNome() {
  var input, toUpperCase, table, tr, td, i, thingValue;
  input = document.getElementById("inputNome");
  toUpperCase = input.value.toUpperCase();
  table = document.getElementById("table-id");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[1];
    if (td) {
      thingValue = td.textContent || td.innerText;
      if (thingValue.toUpperCase().indexOf(toUpperCase) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}

function procurarItemId() {
  var input, toUpperCase, table, tr, td, i, thingValue;
  input = document.getElementById("inputItemId");
  toUpperCase = input.value.toUpperCase();
  table = document.getElementById("table-id");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      thingValue = td.textContent || td.innerText;
      if (thingValue.toUpperCase().indexOf(toUpperCase) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}
