import express from "express";
const app = express();
const port = 3000;

import mysql from "mysql2/promise";

const connection = await mysql.createConnection({
  host: "localhost",
  user: "server",
  database: "mgl802",
  password: "password",
  port: 3306,
});

app.get("/", async (req, res) => {
  const [[applications, fields], [collections, fields2]] = await Promise.all([
    connection
      .query("SELECT * FROM application")
      .then((results, fields) => results),
    connection.query(`
            SELECT collection.*, GROUP_CONCAT(collection_application.application_id) as 'applications'
            FROM collection
            LEFT JOIN collection_application on id = collection_application.collection_id
            GROUP BY id
            `),
  ]);
  res.send({
    applications,
    collections: collections.map((col) => ({
      ...col,
      applications: JSON.parse("[" + col.applications + "]").map((id) =>
        applications.find((app) => app.id === id)
      ),
    })),
  });
});

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`);
});