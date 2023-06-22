$(document).ready(function() {
  function updateData() {
    $.ajax({
      url: 'dataServlet',
      type: 'GET',
      dataType: 'json',
      success: function(data) {
        // 성공적으로 데이터를 받아왔을 때 실행되는 코드
        // temp와 humid 값을 가져와서 화면에 표시합니다.
        $('#temp').text(data.temp);
        $('#humid').text(data.humid);
      },
      error: function(xhr, status, error) {
        // 데이터를 받아오는 데 실패했을 때 실행되는 코드
        console.error('AJAX Error: ' + status + error);
      },
    });
  }

  // 초기 데이터 로딩
  updateData();

  setInterval(updateData, 1000);
});
