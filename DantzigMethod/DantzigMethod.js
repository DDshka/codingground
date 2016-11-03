const inputArray = [
	[0, 1, 2, 1],
	[2, 0, 7, Infinity],
	[6, 5, 0, 2],
	[1, Infinity, 4, 0]
];

const numberOfVertexes = 4;

//Prost)0)
var matrixes = new Array();
var historyMatrix = getWayMatrix();
var m = 0;

function getDantzigMatrixes() {
	if(m == 0) {
		matrixes[m] = inputArray;
		m++;
	}
	else if (m > 4) {
		return;
	}

	let tempMatrix = new Array();
	init2DArray(tempMatrix, numberOfVertexes);
	let z = m - 1;
	for (let i = 0; i < numberOfVertexes; i++) {
		for (let j = 0; j < numberOfVertexes; j++) {
			tempMatrix[i][j] = min(matrixes[z][i][z] + matrixes[z][z][j], matrixes[z][i][j]);
			if (tempMatrix[i][j] < matrixes[z][i][j]) {
				historyMatrix[i][j] = z;
			}
		};
	};

	matrixes[m] = tempMatrix;
	m++;
	getDantzigMatrixes();
}

function getWayMatrix() {
	var matrix = new Array();
	init2DArray(matrix, numberOfVertexes);
	for (let i = 0; i < numberOfVertexes; i++) {
		for (let j = 0; j < numberOfVertexes; j++) {
			if (inputArray[i][j] != 0 && inputArray[i][j] != Infinity) {
				matrix[i][j] = j;
			}
			else {
				matrix[i][j] = -1;
			}
		};
	};
	return matrix;
}

function init2DArray(arr, size) {
	for (let i = 0; i < size; i++) {
		arr[i] = new Array();
	}
}

function min(a, b) {
	return (a < b) ? a : b;
}