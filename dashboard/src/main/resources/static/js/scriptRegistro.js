var columnNameSelect = document.getElementById("columnNameSelect");

// Fetch data from the Spring Boot endpoint using AJAX
fetch("http://localhost:8080/api/data")
  .then((response) => response.json())
  .then((data) => {
    data.forEach(function (dto) {
      var option = document.createElement("option");
      option.value = dto.id;
      option.text = dto.descricao;
      columnNameSelect.appendChild(option);
    });
  })
  .catch((error) => console.error("Error fetching data:", error));

function displaySelectedColumn() {
  var selectedRowId = columnNameSelect.value;
  console.log("Selected Fornecedor ID:", selectedRowId);
}
