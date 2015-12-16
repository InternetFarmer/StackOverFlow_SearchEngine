<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="zh-CN">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Jiadong Wu">
        <title>Stack Never Flow</title>
        <!-- Bootstrap core CSS -->
        <link href="resources/css/lib/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="resources/css/global.css" />
        <link rel="stylesheet" type="text/css" href="resources/css/introduction.css" />
    </head>
    <body>
    <a name="top"></a>
        <!--header-->
        <!--main-->
        <div id="main">

            <div id="tag">
                <svg viewBox="0 0 1320 300">

                <!-- Symbol -->
                <symbol id="s-text">
                    <text text-anchor="middle"
                          x="50%" y="50%" dy=".35em">
                    Stack Never Flow
                    </text>
                </symbol>  
                <!-- Duplicate symbols -->
                <use xlink:href="#s-text" class="text"
                     ></use>
                <use xlink:href="#s-text" class="text"
                     ></use>
                <use xlink:href="#s-text" class="text"
                     ></use>
                <use xlink:href="#s-text" class="text"
                     ></use>
                <use xlink:href="#s-text" class="text"
                     ></use>

                </svg>
            </div>
            <div class="content">
                <div class="row">
                    <div class="col-sm-10">
                        <input class="form-control" type="text" id="formGroupInputLarge" placeholder="Search Key Words.." data-bind="value: SearchTerm">
                    </div>
                    <div class="col-sm-2">
                        <button type="button" autocomplete="off" class="btn btn-primary center-block" data-bind="click: searchAnswer">Smart Search</button>
                    </div>
                </div>
                <br />
                <div class="row">
                    <div class="col-sm-12">
                        <label class="checkbox-inline">
                            <input type="checkbox" value="javascript" data-bind="checked: Tags"> javascript
                        </label>
                        <label class="checkbox-inline">
                            <input type="checkbox" value="java" data-bind="checked: Tags"> java
                        </label>
                        <label class="checkbox-inline">
                            <input type="checkbox" value="php" data-bind="checked: Tags"> php
                        </label>
                        <label class="checkbox-inline">
                            <input type="checkbox" value="android" data-bind="checked: Tags"> android
                        </label>
                        <label class="checkbox-inline">
                            <input type="checkbox" value="jquery" data-bind="checked: Tags"> jquery
                        </label>
                        <label class="checkbox-inline">
                            <input type="checkbox" value="python" data-bind="checked: Tags"> python
                        </label>
                        <label class="checkbox-inline">
                            <input type="checkbox" value="html" data-bind="checked: Tags"> html
                        </label>
                        <label class="checkbox-inline">
                            <input type="checkbox" value="c" data-bind="checked: Tags"> c
                        </label>
                        <label class="checkbox-inline">
                            <input type="checkbox" value="ios" data-bind="checked: Tags"> ios
                        </label>
                        <label class="checkbox-inline">
                            <input type="checkbox" value="mysql" data-bind="checked: Tags"> mysql
                        </label>
                    </div>
                </div>
            </div>
            <br/>
            <!-- ko foreach: Answers -->
            <div id="qbox">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-sm-10">
                                <a data-bind="attr: { href: link()}, html: question.title()" target="_blank"></a>
                            </div>
                            <div class="col-sm-2">
                                <span class="label label-success center-block" data-bind="text: 'Score: '+ score()"></span>
                            </div>
                        </div>
                    </div>
                    <div class="panel-body" data-bind="html: body">question content 
                    </div>
                    <div class="panel-footer">
                        <span class="label label-info" data-bind="text: 'Owner: '+ owner"></span>
                        <!-- ko if: editor !== null -->
                        <span class="label label-info" data-bind="text: 'Editor: '+ editor"></span> 
                        <!-- /ko -->
                        <span class="label label-warning" data-bind="text: 'Date: ' + date"></span>
                    </div>
                </div>
            </div>
            <!-- /ko -->

        </div>
        <!--tool bar-->
        <div class="toolbar">
            <a href="javascript:;" class="toolbar-item toolbar-item-weixin">
                <div class="toolbar-layer">
                    <ul>
                        <li>
                            <img src="resources/images/jiadong.png">
                            <p>
                                <span>Jiadong Wu(jiw97)</span>
                                <span>In this project, I take responsibility of building up the whole project framework.</span>
                            </p>
                        </li>
                        <li>
                            <img src="resources/images/yanyan.png">
                            <p>
                                <span>Yanyan Zhou(yaz61)</span>
                                <span>In this project, I take responsibility of implementing search algorithms.</span>
                            </p>
                        </li>
                        <li>
                            <img src="resources/images/dan.png">
                            <p>
                                <span>Dan Sun(das225)</span>
                                <span>In this project, I take responsibility of designing and developing the front-end web pages.</span>
                            </p>
                        </li>
                    </ul>
                </div>
            </a>
            <a href="#top"  class="toolbar-item toolbar-item-top"></a>
        </div>

        <!--footer-->
        <div id="footer">
            <div id="footer-contact">
                <ul>
                    <li>Jiadong Wu:<span>jiw97@pitt.edu</span></li>
                    <li>Yanyan Zhou:<span>yaz61@pitt.edu</span></li>
                    <li>Dan Sun:<span>das225@pitt.edu</span></li>

                </ul>
            </div>
        </div>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script type="text/javascript" src="resources/JS/lib/jquery-2.1.4.min.js"></script>
        <script src="resources/JS/lib/bootstrap.min.js"></script>
        <script type='text/javascript' src='resources/JS/lib/knockout-3.4.0.js'></script>
        <script type="text/javascript" src="resources/JS/lib/bootstrap-datepicker.js"></script>
        <script type="text/javascript" src = 'resources/JS/main.js'></script>
        <script type="text/javascript" src="resources/JS/front.js"></script>
        <script type="text/javascript">
                                    ko.applyBindings(new MyModel());
        </script>
    </body>
</html>
