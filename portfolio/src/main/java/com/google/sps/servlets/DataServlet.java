// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import java.io.IOException;
import com.google.gson.reflect.TypeToken; 
import java.lang.reflect.Type; 
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet that returns some example content. TODO: modify this file to handle comments data */
@WebServlet("/data")
public class DataServlet extends HttpServlet {
  
  ArrayList<String> detailsAboutMe = new ArrayList<String>();

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    detailsAboutMe.add("Soniya Nayak");
    detailsAboutMe.add("Female");
    detailsAboutMe.add("Indian");

    String json = convertToJsonUsingGson();
    response.setContentType("application/json;");
    response.getWriter().println(json);
  }
  private String convertToJsonUsingGson() {
    Type listType = new TypeToken<ArrayList<String>>() {}.getType();
    Gson gson = new Gson();
    String json = gson.toJson(detailsAboutMe, listType);
    return json;
  }
}
