const width_threshold = 480;
const sp1 = document.getElementById("sp1");
const sp2 = document.getElementById("sp2");
const sp3 = document.getElementById("sp3");
const sp4 = document.getElementById("sp4");
const sp5 = document.getElementById("sp5");
const sp6 = document.getElementById("sp6");
const sp7 = document.getElementById("sp7");
const sp8 = document.getElementById("sp8");
const sp9 = document.getElementById("sp9");
const sp10 = document.getElementById("sp10");
const sp11 = document.getElementById("sp11");
const sp12 = document.getElementById("sp12");
const sr1 = document.getElementById("sr1");
const sr2 = document.getElementById("sr2");
const sr3 = document.getElementById("sr3");
const sr4 = document.getElementById("sr4");
const sr5 = document.getElementById("sr5");
const sr6 = document.getElementById("sr6");
const sr7 = document.getElementById("sr7");
const sr8 = document.getElementById("sr8");
const sr9 = document.getElementById("sr9");
const sr10 = document.getElementById("sr10");
const sr11 = document.getElementById("sr11");
const sr12 = document.getElementById("sr12");
const mp = document.getElementById("mp");
const mr = document.getElementById("mr");

function drawLineChart() {
  if ($("#lineChart").length) {
    ctxLine = document.getElementById("lineChart").getContext("2d");
    optionsLine = {
      scales: {
        yAxes: [
          {
            scaleLabel: {
              display: true,
              labelString: "Hits"
            }
          }
        ]
      }
    };

    // Set aspect ratio based on window width
    optionsLine.maintainAspectRatio =
      $(window).width() < width_threshold ? false : true;

    configLine = {
      type: "line",
      data: {
        labels: [
          "1월",
          "2월",
          "3월",
          "4월",
          "5월",
          "6월",
          "7월",
          "8월",
          "9월",
          "10월",
          "11월",
          "12월"
        ],
        datasets: [
          {
            label: "판매",
            data: [sp1.value, sp2.value, sp3.value, sp4.value, sp5.value, sp6.value, sp7.value, sp8.value,
              sp9.value, sp10.value, sp11.value, sp12.value],
            fill: false,
            borderColor: "rgb(75, 192, 192)",
            cubicInterpolationMode: "monotone",
            pointRadius: 0
          },
          {
            label: "환불",
            data: [sr1.value, sr2.value, sr3.value, sr4.value, sr5.value, sr6.value, sr7.value, sr8.value,
              sr9.value, sr10.value, sr11.value, sr12.value],
            fill: false,
            borderColor: "rgba(255,99,132,1)",
            cubicInterpolationMode: "monotone",
            pointRadius: 0
          },
          {
            label: "매출 총액(구입-환불)",
            data: [sp1.value-sr1.value, sp2.value-sr2.value, sp3.value-sr3.value, sp4.value-sr4.value,
              sp5.value-sr5.value, sp6.value-sr6.value, sp7.value-sr7.value, sp8.value-sr8.value,
              sp9.value-sr9.value, sp10.value-sr10.value, sp11.value-sr11.value, sp12.value-sr12.value],
            fill: false,
            borderColor: "rgba(153, 102, 255, 1)",
            cubicInterpolationMode: "monotone",
            pointRadius: 0
          }
        ]
      },
      options: optionsLine
    };

    lineChart = new Chart(ctxLine, configLine);
  }
}

function drawBarChart() {
  if ($("#barChart").length) {
    ctxBar = document.getElementById("barChart").getContext("2d");

    optionsBar = {
      responsive: true,
      scales: {
        yAxes: [
          {
            barPercentage: 0.2,
            ticks: {
              beginAtZero: true
            },
            scaleLabel: {
              display: true,
              labelString: "Hits"
            }
          }
        ]
      }
    };

    optionsBar.maintainAspectRatio =
      $(window).width() < width_threshold ? false : true;

    /**
     * COLOR CODES
     * Red: #F7604D
     * Aqua: #4ED6B8
     * Green: #A8D582
     * Yellow: #D7D768
     * Purple: #9D66CC
     * Orange: #DB9C3F
     * Blue: #3889FC
     */

    configBar = {
      type: "horizontalBar",
      data: {
        labels: ["판매", "환불", "총액"],
        datasets: [
          {
            label: "# of Hits",
            data: [mp.value, mr.value, mp.value-mr.value],
            backgroundColor: [
              "#4ED6B8",
              "#F7604D",
              "#9D66CC"
            ],
            borderWidth: 0
          }
        ]
      },
      options: optionsBar
    };

    barChart = new Chart(ctxBar, configBar);
  }
}

function drawPieChart() {
  if ($("#pieChart").length) {
    var chartHeight = 300;

    $("#pieChartContainer").css("height", chartHeight + "px");

    ctxPie = document.getElementById("pieChart").getContext("2d");

    optionsPie = {
      responsive: true,
      maintainAspectRatio: false,
      layout: {
        padding: {
          left: 10,
          right: 10,
          top: 10,
          bottom: 10
        }
      },
      legend: {
        position: "top"
      }
    };

    configPie = {
      type: "pie",
      data: {
        datasets: [
          {
            data: [18.24, 6.5, 9.15],
            backgroundColor: ["#F7604D", "#4ED6B8", "#A8D582"],
            label: "Storage"
          }
        ],
        labels: [
          "Used Storage (18.240GB)",
          "System Storage (6.500GB)",
          "Available Storage (9.150GB)"
        ]
      },
      options: optionsPie
    };

    pieChart = new Chart(ctxPie, configPie);
  }
}

function updateLineChart() {
  if (lineChart) {
    lineChart.options = optionsLine;
    lineChart.update();
  }
}

function updateBarChart() {
  if (barChart) {
    barChart.options = optionsBar;
    barChart.update();
  }
}
