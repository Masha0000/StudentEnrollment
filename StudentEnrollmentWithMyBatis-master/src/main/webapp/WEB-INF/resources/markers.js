var  coordinates=[];
var typeFeature;
var typeFeatureAdd;
var  coordinatesAdd=[];
  var   coordinatesFeatureDel;
  var typeFeatureDel;
var raster = new ol.layer.Tile({
  source: new ol.source.OSM()
});

var center= new ol.proj.transform([39.195067, 51.667360], 'EPSG:4326', 'EPSG:3857');

var vector = new ol.layer.Vector({
  source: new ol.source.Vector(),
  style: new ol.style.Style({
    fill: new ol.style.Fill({
      color: 'rgba(255, 255, 255, 0.2)'
    }),
    stroke: new ol.style.Stroke({
      color: '#ffcc33',
      width: 2
    }),
    image: new ol.style.Circle({
      radius: 7,
      fill: new ol.style.Fill({
        color: '#ffcc33'
      })
    })
  })
});

var map = new ol.Map({
  layers: [raster, vector],
  target: 'map',
  view: new ol.View({
    center:center,
    zoom: 4
  })
});


var Delete = {
init: function() {
this.select = new ol.interaction.Select();
map.addInteraction(this.select);
this.modify = new ol.interaction.Modify({
features: this.select.getFeatures()
});
map.addInteraction(this.modify);
this.setEvents();
},
setEvents: function() {
var selectedFeatures = this.select.getFeatures();
this.select.on('change:active', function() {
selectedFeatures.forEach(selectedFeatures.remove, selectedFeatures);
});
/* This method remove figure from map as a modyfi end,
get ID of this figur and send it to the server. */
this.modify.on('modifyend', function(e) {
var features = e.features.getArray();
coordinatesFeatureDel=features[0].getGeometry().getCoordinates();
console.log(coordinatesFeatureDel);
typeFeature=features[0].getGeometry().getType();
console.log(typeFeature);

vector.getSource().removeFeature(features[0]);
selectedFeatures.forEach(selectedFeatures.remove, selectedFeatures);

});
},
setActive: function(active) {
this.select.setActive(active);
this.modify.setActive(active);
}
}
Delete.init();



var Modify = {
  init: function() {
        this.select = new ol.interaction.Select();
        map.addInteraction(this.select);

        this.modify = new ol.interaction.Modify({
          features: this.select.getFeatures()
        });
        map.addInteraction(this.modify);

        this.setEvents();

     },

    setEvents: function() {
          var selectedFeatures = this.select.getFeatures();

          this.select.on('change:active', function() {
              selectedFeatures.forEach(selectedFeatures.remove, selectedFeatures);
          });


          var i=0;

          this.select.on('select', function(event) {
            coordinates[i]=event.selected[0].getGeometry().getCoordinates();
            console.log(coordinates[i]);
            typeFeature=event.selected[0].getGeometry().getType();


              console.log(typeFeature);
              var FeatureJs =JSON.stringify( {
                  'name': typeFeature,
               //   'coord': coordinates[0]
                  'coord': coordinates

              });
              $.ajax({

                      url:"/modify",
                  type: 'POST',
                      data: FeatureJs,
                      dataType:'json',
                      contentType:'application/json;charset=utf-8',
                      success:function(data){
                          console.log(data);
                          alert("success");

                      },
                      error:function (e) {
                          alert('error post');

                      }
                  }
              );

              console.log("Post");

      });
      //  this.setPost(typeFeature,coordinates);

    },

    setActive: function(active) {
      this.select.setActive(active);
      this.modify.setActive(active);
    },

};
  Modify.init();



  var optionsForm = document.getElementById('options-form');

  var Draw = {
    init: function() {
      map.addInteraction(this.Point);
      this.Point.setActive(false);
      map.addInteraction(this.LineString);
      this.LineString.setActive(false);
      map.addInteraction(this.Polygon);
      this.Polygon.setActive(false);
      map.addInteraction(this.Circle);
      this.Circle.setActive(false);
    },
    Point: new ol.interaction.Draw({
      source: vector.getSource(),
      type: 'Point'
    }),
    LineString: new ol.interaction.Draw({
      source: vector.getSource(),
      type: 'LineString'
    }),
    Polygon: new ol.interaction.Draw({
      source: vector.getSource(),
      type: 'Polygon'
    }),
    Circle: new ol.interaction.Draw({
      source: vector.getSource(),
      type: 'Circle'
    }),
    getActive: function() {
      return this.activeType ? this[this.activeType].getActive() : false;
    },
    setActive: function(active) {
      var type = optionsForm.elements['draw-type'].value;
      if (active) {
        this.activeType && this[this.activeType].setActive(false);
        this[type].setActive(true);
        this.activeType = type;
      } else {
        this.activeType && this[this.activeType].setActive(false);
        this.activeType = null;
      }

      console.log(this[type]);
    /*  var i=0;
      this.select.on('select', function(event) {
        coordinatesAdd[i]=event.selected[0].getGeometry().getCoordinates();
        console.log(coordinatesAdd[i]);
        typeFeatureAdd=event.selected[0].getGeometry().getType();
        console.log(type);
      });*/
  }
};
Draw.init();



/**
 * Let user change the geometry type.
 * @param {Event} e Change event.
 */
optionsForm.onchange = function(e) {
  var type = e.target.getAttribute('name');
  var value = e.target.value;
  if (type == 'draw-type') {
    Draw.getActive() && Draw.setActive(true);
  } else if (type == 'interaction') {
    if (value == 'modify') {
      Draw.setActive(false);
      Modify.setActive(true);
      Delete.setActive(false);

    } else if (value == 'draw') {
      Draw.setActive(true);
      Modify.setActive(false);
      Delete.setActive(false);

    }
    else if(value =='delete')
    {
      Draw.setActive(false);
      Modify.setActive(false);
      Delete.setActive(true);

    }
  }
};

Draw.setActive(true);
Modify.setActive(false);
Delete.setActive(false);
// The snap interaction must be added after the Modify and Draw interactions
// in order for its map browser event handlers to be fired first. Its handlers
// are responsible of doing the snapping.
var snap = new ol.interaction.Snap({
  source: vector.getSource()
});
map.addInteraction(snap);
