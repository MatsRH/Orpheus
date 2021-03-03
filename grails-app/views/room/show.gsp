<!DOCTYPE html>

<html>
    <style>
      .button {
      border: none;
      color: white;
      padding: 15px 32px;
      text-align: center;
      text-decoration: none;
      display: inline-block;
      font-size: 16px;
      margin: 4px 2px;
      cursor: pointer;
      }

      .button1 {background-color: #4CAF50;} /* Green */
      .button2 {background-color: #008CBA;} /* Blue */
    </style>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'room.label', default: 'Room')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-room" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="show-room" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" />
              <g:form resource="${this.room}" method="DELETE">
                  <fieldset class="buttons">
                      <g:link class="edit" action="edit" resource="${this.room}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                      <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                  </fieldset>
              </g:form>
            </h1>
            <g:if test="${flash.message}">
              <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:display bean="room" />
            <div id="record-room" class="content scaffold-show" role="main">
                <g:if test="${flash.TrackStatus}">
                  <div class="message" role="status">${flash.TrackStatus}</div>
                </g:if>

                <!-- OLD
                <title>Simple Recorder.js demo with record, stop and pause</title>
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <div id="controls">
                  <button id="recordButton">Record</button>
                  <button id="pauseButton" disabled>Pause</button>
                  <button id="stopButton" disabled>Stop</button>
                </div>
                <h3>Recordings</h3>
                <ol id="recordingsList"></ol>
                -->

                <audio controls autoplay></audio>
                <asset:javascript src="recorder-Old.js"/>
                <fieldset><legend>RECORD AUDIO</legend>
                  <input onclick="startRecording()" type="button" value="start recording" />
                  <input onclick="stopRecording()" type="button" value="stop recording and play" />
                </fieldset>
                <g:javascript>
                  var onFail = function(e) {
                    console.log('Rejected!', e);
                  };

                  var onSuccess = function(s) {
                    var context = new webkitAudioContext();
                    var mediaStreamSource = context.createMediaStreamSource(s);
                    recorder = new Recorder(mediaStreamSource);
                    recorder.record();

                    // audio loopback
                    // mediaStreamSource.connect(context.destination);
                  }

                  window.URL = window.URL || window.webkitURL;
                  navigator.getUserMedia  = navigator.getUserMedia || navigator.webkitGetUserMedia || navigator.mozGetUserMedia || navigator.msGetUserMedia;

                  var recorder;
                  var audio = document.querySelector('audio');

                  function startRecording() {
                    if (navigator.getUserMedia) {
                      navigator.getUserMedia({audio: true}, onSuccess, onFail);
                    } else {
                      console.log('navigator.getUserMedia not present');
                    }
                  }

                  function stopRecording() {
                    recorder.stop();
                    recorder.exportWAV(function(s) {
                      audio.src = window.URL.createObjectURL(s);
                    });
                  }
                </g:javascript>
            </div>
        </div>
    <!--
    <g:javascript>
        function myFunction() {
          alert("RECORDING!");
        }
    </g:javascript>
    <asset:javascript src="jquery-2.2.0.min.js"/>
    <asset:javascript src="recorder-Old.js"/>
    <asset:javascript src="app.js"/>
    -->

    </body>


</html>



