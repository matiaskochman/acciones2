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
				 <span class="label label-default">Price change 52w</span>
			</div>
			<div class="col-md-1">
				 <span class="label label-default">Shares traded</span>
			</div>
			<div class="col-md-4">
				 <span class="label label-default">Title</span>
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
			{{company.price52WeekPercChange}}
			</div>
			<div class="col-md-1">
			{{company.volumenNegociado}}
			</div>
			<div class="col-md-4">
			{{company.title}}
			</div>
		  
		</li>
	  </ul>	
	</div>


</body>
