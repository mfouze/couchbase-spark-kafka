package utils

import com.github.stijndehaes.playprometheusfilters.filters.StatusAndRouteLatencyAndCounterFilter
import com.google.inject.Inject
import play.api.http.{DefaultHttpFilters, EnabledFilters}

class Filters @Inject()(defaultFilters: EnabledFilters,
                        statusAndRouteLatencyAndCounterFilter: StatusAndRouteLatencyAndCounterFilter,
                        log: LoggingFilter) extends DefaultHttpFilters(defaultFilters.filters :+ statusAndRouteLatencyAndCounterFilter :+ log: _*)


