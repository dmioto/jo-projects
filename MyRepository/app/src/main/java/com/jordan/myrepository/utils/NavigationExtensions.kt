package com.jordan.myrepository.utils

import android.os.Bundle
import androidx.annotation.NavigationRes
import androidx.navigation.NavController

fun NavController.setStartDestinationNav(@NavigationRes navGraph: Int, startDestiny: () -> Int) {
    val graph = this.navInflater.inflate(navGraph)
    graph.setStartDestination(startDestiny())
    this.graph = graph
}

fun NavController.setStartDestinationNav(@NavigationRes navGraph: Int, fragmentRes: Int, bundle: Bundle) {
    val graph = this.navInflater.inflate(navGraph)
    graph.setStartDestination(fragmentRes)
    this.setGraph(graph, bundle)
}