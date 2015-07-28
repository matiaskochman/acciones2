<body ng-controller="ForecastListCtrl">

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-1">
				 <span class="label label-default">ticker</span>
			</div>
			<div class="col-md-1">
				 <span class="label label-default">market</span>
			</div>
			<div class="col-md-1">
				 <span class="label label-default">Average</span>
			</div>
			<div class="col-md-1">
				 <span class="label label-default">Max</span>
			</div>
			<div class="col-md-1">
				 <span class="label label-default">Med</span>
			</div>
			<div class="col-md-1">
				 <span class="label label-default">Min</span>
			</div>
			<div class="col-md-1">
				 <span class="label label-default">Label</span>
			</div>
			<div class="col-md-1">
				 <span class="label label-default">Label</span>
			</div>
			<div class="col-md-1">
				 <span class="label label-default">Label</span>
			</div>
			<div class="col-md-1">
				 <span class="label label-default">Label</span>
			</div>
			<div class="col-md-1">
				 <span class="label label-default">Label</span>
			</div>
			<div class="col-md-1">
				 <span class="label label-default">Label</span>
			</div>
		</div>
		
	  <ul>
		<li ng-repeat="company in companies">
		  
			<div class="col-md-1">
			{{company.ticker}}
			</div>
			<div class="col-md-1">
			{{company.exchange}}
			</div>
			<div class="col-md-1">
			{{company.recomendacionAverage}}
			</div>
			<div class="col-md-1">
			{{company.maxForecastPercentageValue}}
			</div>
			<div class="col-md-1">
			{{company.medForecastPercentageValue}}
			</div>
			<div class="col-md-1">
			{{company.minForecastPercentageValue}}
			</div>
			<div class="col-md-1">
			</div>
			<div class="col-md-1">
			</div>
			<div class="col-md-1">
			</div>
			<div class="col-md-1">
			</div>
			<div class="col-md-1">
			</div>
			<div class="col-md-1">
			</div>
		  
		</li>
	  </ul>	
	</div>


</body>
