<!DOCTYPE html>
<html>
  <head>
    <title>Snap Interaction</title>
    <meta charset="UTF-8">

    <link rel="stylesheet" href="https://openlayers.org/en/v4.6.5/css/ol.css" type="text/css">
    <!-- The line below is only needed for old environments like Internet Explorer and Android 4.x -->
    <script src="https://cdn.polyfill.io/v2/polyfill.min.js?features=requestAnimationFrame,Element.prototype.classList,URL"></script>
    <script src="https://openlayers.org/en/v4.6.5/build/ol.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>

  </head>
  <body>
    <div id="map" class="map"></div>
    <form id="options-form" automplete="off">
      <div class="radio">
        <label>
          <input type="radio" name="interaction" value="draw" id="draw" checked>
          Draw &nbsp;
        </label>
      </div>
      <div class="radio">
        <label>
          <input type="radio" name="interaction" value="delete">
          Delete &nbsp;
        </label>
      </div>
      <div class="radio">
        <label>
          <input type="radio" name="interaction" value="modify">
          Modify &nbsp;
        </label>
      </div>
      <div class="form-group">
        <label>Draw type &nbsp;</label>
        <select name="draw-type" id="draw-type">
          <option value="Point">Point</option>
          <option value="LineString">LineString</option>
          <option value="Polygon">Polygon</option>
          <option value="Circle">Circle</option>
        </select>
      </div>
    </form>
    <script src="/resources/markers.js"></script>
  </body>
</html>
