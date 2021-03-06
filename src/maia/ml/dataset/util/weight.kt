package maia.ml.dataset.util

/*
 * Package for manipulating the weights of data-rows.
 */

import maia.ml.dataset.DataRow
import maia.ml.dataset.WithWeight

/**
 * Gets the weight of a data-row, defaulting to 1.0 if the
 * row is unweighted.
 */
val DataRow.weight: Double
    get() = if (this is WithWeight) weight else 1.0
