<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>

<style>
*{margin:0;padding:0;}
body{padding:100px;background:#929292;font-size:100%;font-family:"Arial";}
input{font-size:1em;}
ol.tree{padding-left:30px;}
li{list-style-type:none;color:#fff;position:relative;margin-left:-15px;}
li label{padding-left:37px;cursor:pointer;background:url("https://www.thecssninja.com/demo/css_tree/folder-horizontal.png") no-repeat 15px 2px;display:block;}
li input{width:1em;height:1em;position:absolute;left:-0.5em;top:0;opacity:0;cursor:pointer;}
li input + ol{height:1em;margin:-16px 0 0 -44px;background:url("https://www.thecssninja.com/demo/css_tree/toggle-small-expand.png") no-repeat 40px 0;}
li input + ol > li{display:none;margin-left:-14px !important;padding-left:1px}
li.file{margin-left:-1px !important;}
li.file a{display:inline-block;padding-left:21px;color:#fff;text-decoration:none;background:url("https://www.thecssninja.com/demo/css_tree/document.png") no-repeat 0 0;}
li input:checked + ol{height:auto;margin:-21px 0 0 -44px;padding:25px 0 0 80px;background:url("https://www.thecssninja.com/demo/css_tree/toggle-small.png") no-repeat 40px 5px;}
li input:checked + ol > li{display:block;margin:0 0 0.063em;}
li input:checked + ol > li:first-child{margin:0 0 0.125em;}
</style>

</head>
<body>

            <div class="well sidebar-nav">

				<ol class="tree">
				  <li>
				    <label for="menu-1">menu-1</label>
				    <input type="checkbox" checked id="menu-1" />
				    <ol>
				      <li>
				        <label for="menu-1-1">menu-1-1</label>
				        <input type="checkbox" id="menu-1-1" />
				        <ol>
				          <li>
				            <label for="menu-1-1-1">menu-1-1-1</label>
				            <input type="checkbox" id="menu-1-1-1" />
				            <ol>
				              <li>
				                <label for="menu-1-1-1-1">menu-1-1-1-1</label>
				                <input type="checkbox" id="menu-1-1-1-1" />
				                <ol>
				                  <li class="file"><a href="">menu-1-1-1-1-1</a></li>
				                  <li class="file"><a href="">menu-1-1-1-1-2</a></li>
				                  <li class="file"><a href="">menu-1-1-1-1-3</a></li>
				                </ol>
				              </li>
				              <li class="file"><a href="">menu-1-1-1-2</a></li>
				              <li class="file"><a href="">menu-1-1-1-3</a></li>
				              <li class="file"><a href="">menu-1-1-1-4</a></li>
				              <li class="file"><a href="">menu-1-1-1-5</a></li>
				              <li class="file"><a href="">menu-1-1-1-6</a></li>
				            </ol>
				          </li>
				          <li class="file"><a href="">menu-1-1-2</a></li>
				          <li class="file"><a href="">menu-1-1-3</a></li>
				          <li class="file"><a href="">menu-1-1-4</a></li>
				        </ol> 
				      </li>
				      <li class="file"><a href="">menu-1-2</a></li>
				      <li class="file"><a href="">menu-1-3</a></li>
				    </ol>
				  </li>
				  
				  <li>
				    <label for="menu-2">menu-2</label>
				    <input type="checkbox" id="menu-2" />
				    <ol>
				      <li>
				        <label for="menu-2-1">menu-2-1</label>
				        <input type="checkbox" id="menu-2-1" />
				        <ol>
				          <li>
				            <label for="menu-2-1-1">menu-2-1-1</label>
				            <input type="checkbox" id="menu-2-1-1" />
				            <ol>
				              <li class="file"><a href="">menu-2-1-1-1</a></li>
				              <li class="file"><a href="">menu-2-1-1-2</a></li>
				              <li class="file"><a href="">menu-2-1-1-3</a></li>
				              <li class="file"><a href="">menu-2-1-1-4</a></li>
				              <li class="file"><a href="">menu-2-1-1-5</a></li>
				            </ol>
				          </li>
				          <li class="file"><a href="">menu-2-1-2</a></li>
				          <li class="file"><a href="">menu-2-1-3</a></li>
				          <li class="file"><a href="">menu-2-1-4</a></li>
				        </ol> 
				      </li>
				      <li class="file"><a href="">menu-2-2</a></li>
				      <li class="file"><a href="">menu-2-3</a></li>
				    </ol>
				  </li>
				  
				  <li>
				    <label for="menu-3">menu-3</label>
				    <input type="checkbox" id="menu-3" />
				    <ol>
				      <li>
				        <label for="menu-3-1">menu-3-1</label>
				        <input type="checkbox" id="menu-3-1" />
				        <ol>
				          <li>
				            <label for="menu-3-1-1">menu-3-1-1</label>
				            <input type="checkbox" id="menu-3-1-1" />
				            <ol>
				              <li class="file"><a href="">menu-3-1-1-1</a></li>
				              <li class="file"><a href="">menu-3-1-1-2</a></li>
				              <li class="file"><a href="">menu-3-1-1-3</a></li>
				              <li class="file"><a href="">menu-3-1-1-4</a></li>
				              <li class="file"><a href="">menu-3-1-1-5</a></li>
				            </ol>
				          </li>
				          <li class="file"><a href="">menu-3-1-2</a></li>
				          <li class="file"><a href="">menu-3-1-3</a></li>
				          <li class="file"><a href="">menu-3-1-4</a></li>
				        </ol> 
				      </li>
				      <li class="file"><a href="">menu-3-2</a></li>
				      <li class="file"><a href="">menu-3-3</a></li>
				    </ol>
				  </li>
				  
				  <li>
				    <label for="menu-4">menu-4</label>
				    <input type="checkbox" id="menu-4" />
				    <ol>
				      <li>
				        <label for="menu-4-1">menu-4-1</label>
				        <input type="checkbox" id="menu-4-1" />
				        <ol>
				          <li>
				            <label for="menu-4-1-1">menu-4-1-1</label>
				            <input type="checkbox" id="menu-4-1-1" />
				            <ol>
				              <li class="file"><a href="">menu-4-1-1-1</a></li>
				              <li class="file"><a href="">menu-4-1-1-2</a></li>
				              <li class="file"><a href="">menu-4-1-1-3</a></li>
				              <li class="file"><a href="">menu-4-1-1-4</a></li>
				              <li class="file"><a href="">menu-4-1-1-5</a></li>
				            </ol>
				          </li>
				          <li class="file"><a href="">menu-4-1-2</a></li>
				          <li class="file"><a href="">menu-4-1-3</a></li>
				          <li class="file"><a href="">menu-4-1-4</a></li>
				        </ol> 
				      </li>
				      <li class="file"><a href="">menu-4-2</a></li>
				      <li class="file"><a href="">menu-4-3</a></li>
				    </ol>
				  </li>
				  
				  <li>
				    <label for="menu-5">menu-5</label>
				    <input type="checkbox" id="menu-5" />
				    <ol>
				      <li>
				        <label for="menu-5-1">menu-5-1</label>
				        <input type="checkbox" id="menu-5-1" />
				        <ol>
				          <li>
				            <label for="menu-5-1-1">menu-5-1-1</label>
				            <input type="checkbox" id="menu-5-1-1" />
				            <ol>
				              <li class="file"><a href="">menu-5-1-1-1</a></li>
				              <li class="file"><a href="">menu-5-1-1-2</a></li>
				              <li class="file"><a href="">menu-5-1-1-3</a></li>
				              <li class="file"><a href="">menu-5-1-1-4</a></li>
				              <li class="file"><a href="">menu-5-1-1-5</a></li>
				            </ol>
				          </li>
				          <li class="file"><a href="">menu-5-1-2</a></li>
				          <li class="file"><a href="">menu-5-1-3</a></li>
				          <li class="file"><a href="">menu-5-1-4</a></li>
				        </ol> 
				      </li>
				      <li class="file"><a href="">menu-5-2</a></li>
				      <li class="file"><a href="">menu-5-3</a></li>
				    </ol>
				  </li>
				  
				</ol>     

</div>
</body>
</html>