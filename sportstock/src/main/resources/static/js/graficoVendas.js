// /src/main/resources/static/js/graficoVendas.js

document.addEventListener("DOMContentLoaded", function () {
    // Aguardar o carregamento completo do conteúdo da página

    const dadosVendas = JSON.parse(document.getElementById("dadosVendas").textContent);

    const ctx = document.getElementById('graficoVendas').getContext('2d');
    const graficoVendas = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: dadosVendas.map(venda => venda.nomeProduto),  // Labels dos produtos
            datasets: [{
                label: 'Total de Vendas (R$)',
                data: dadosVendas.map(venda => venda.totalVendas),  // Total das vendas para cada produto
                backgroundColor: 'rgba(54, 162, 235, 0.2)',
                borderColor: 'rgba(54, 162, 235, 1)',
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
});
