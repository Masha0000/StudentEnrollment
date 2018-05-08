


var raster = new ol.layer.Tile({
  source: new ol.source.OSM()
});

var center= new ol.proj.transform([39.195067, 51.667360], 'EPSG:4326', 'EPSG:3857');
var vectorFill = new ol.layer.Vector({
  source: new ol.source.Vector(),
  style: new ol.style.Style({
    fill: new ol.style.Fill({
      color: 'rgba(255, 255, 255, 0.2)'
    })
  })
});

    var strokeVector = new ol.layer.Vector({
      source: new ol.source.Vector(),
      style: new ol.style.Style({
    stroke: new ol.style.Stroke({
      color: '#ffcc33',
      width: 2
    })
  })
});


var map = new ol.Map({
  layers: [raster, vectorFill,strokeVector],
  target: 'map',
  view: new ol.View({
    center: center,
    zoom: 10
  })
});



// //function drawAndModify() {
// //.*
// //var newFeature = new ol.Collection(vector_layer.getSource().getFeatures())
//
// // modify_interaction = new ol.interaction.Modify({
//   // features: newFeature
//  /});
//
//  // add it to the map
//  map.addInteraction(modify_interaction);
//
// //});
//
// //

      var modify = new ol.interaction.Modify({source:source1});
       map.addInteraction(modify);


       var draw, snap; // global so we can remove them later
       var typeSelect = document.getElementById('draw-type');

       function addInteractions() {
         draw = new ol.interaction.Draw({
           source: source,
           type: typeSelect.value
         });
         map.addInteraction(draw);
         snap = new ol.interaction.Snap({source: source});
         map.addInteraction(snap);

       }

       /**
        * Handle change event.
        */
       typeSelect.onchange = function() {
         map.removeInteraction(draw);
         map.removeInteraction(snap);
         addInteractions();
       };

       addInteractions();
}
